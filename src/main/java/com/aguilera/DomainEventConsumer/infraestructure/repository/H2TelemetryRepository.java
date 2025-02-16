package com.aguilera.DomainEventConsumer.infraestructure.repository;

import com.aguilera.DomainEventConsumer.domain.CreationTime;
import com.aguilera.DomainEventConsumer.domain.DeviceId;
import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import com.aguilera.DomainEventConsumer.domain.exceptions.AlreadyExistsTelemetryException;
import com.aguilera.DomainEventConsumer.domain.exceptions.FindTelemetryException;
import com.aguilera.DomainEventConsumer.domain.exceptions.RemoveOldTelemetriesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.aguilera.DomainEventConsumer.domain.exceptions.SaveTelemetryException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class H2TelemetryRepository implements TelemetryRepository {
  private final NamedParameterJdbcTemplate jdbcTemplate;

  public H2TelemetryRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Telemetry> findAll() {
    String sql = """
      SELECT DEVICE_ID, MEASUREMENT, CREATION_DATE FROM TELEMETRY;
      """;
    try {
      return jdbcTemplate.query(sql, mapResultSetToTelemetry());
    }catch (DataAccessException e){
      throw new FindTelemetryException(e);
    }
  }

  @Override
  public void save(Telemetry telemetry) {
    String sql = """
      INSERT INTO TELEMETRY(DEVICE_ID, MEASUREMENT, CREATION_DATE) VALUES(:deviceId, :value, :date);
      """;
    Map<String, Object> params = Map.of(
      "deviceId",
      telemetry.getDeviceId().getValue(),
      "value",
      telemetry.getMeasurement(),
      "date",
      telemetry.getCreationTime().getValue()
    );
    try {
      jdbcTemplate.update(sql, params);
    } catch (DuplicateKeyException e) {
      throw new AlreadyExistsTelemetryException();
    } catch (DataAccessException e) {
      throw new SaveTelemetryException(e);
    }
  }

  @Override
  public void removeOlderThan(DeviceId deviceId, CreationTime creationTime) {
    String sql = """
      DELETE FROM TELEMETRY WHERE DEVICE_ID = :deviceId AND CREATION_DATE < :date
      """;

    Map<String, Object> params = Map.of("deviceId", deviceId.getValue(), "date", creationTime.getValue());

    try {
      jdbcTemplate.update(sql, params);
    } catch (DataAccessException e) {
      throw new RemoveOldTelemetriesException(e);
    }
  }

  private RowMapper<Telemetry> mapResultSetToTelemetry() {
    return (rs, rowNum) -> {
      DeviceId deviceId = new DeviceId(rs.getInt("DEVICE_ID"));
      Integer measurement = rs.getInt("MEASUREMENT");
      CreationTime creationDate = new CreationTime(rs.getObject("CREATION_DATE", OffsetDateTime.class));
      return new Telemetry(deviceId, measurement, creationDate);
    };
  }
}
