package com.aguilera.DomainEventConsumer.infraestructure.repository;

import com.aguilera.DomainEventConsumer.domain.Telemetry;
import com.aguilera.DomainEventConsumer.domain.TelemetryRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class H2TelemetryRepository implements TelemetryRepository {
  private final NamedParameterJdbcTemplate jdbcTemplate;

  public H2TelemetryRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
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
    jdbcTemplate.update(sql, params);
  }
}
