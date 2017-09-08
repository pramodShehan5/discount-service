DO $$
DECLARE
   country_data RECORD;
BEGIN

FOR country_data IN select id from t_country
  LOOP
     INSERT INTO t_countryconfiguration("id","country_id","configuration_id","enabled")  values (nextval('t_countryconfiguration_id_seq'),country_data.id,(select id from t_configuration  where code = 'TAX_COPY_ENABLED'),false);
  END LOOP;

END$$;