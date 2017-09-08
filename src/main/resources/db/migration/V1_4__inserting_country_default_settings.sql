DO $$
DECLARE
   country_data RECORD;
BEGIN

FOR country_data IN select id from t_country
  LOOP
     INSERT INTO t_countrysetting("id","country_id","setting_id","allowed","test")  values (nextval('t_countrysetting_id_seq'),country_data.id,(select id from t_setting  where code = 'WEB_INVOICE_ALLOWED'),true,true);
     INSERT INTO t_countrysetting("id","country_id","setting_id","allowed","test")  values (nextval('t_countrysetting_id_seq'),country_data.id,(select id from t_setting  where code = 'ARCHIVE_ALLOWED'),true,true);
     INSERT INTO t_countrysetting("id","country_id","setting_id","allowed","test")  values (nextval('t_countrysetting_id_seq'),country_data.id,(select id from t_setting  where code = 'INTRUSIVE_ENRICHMENT_ALLOWED'),true,true);
     INSERT INTO t_countrysetting("id","country_id","setting_id","allowed","test")  values (nextval('t_countrysetting_id_seq'),country_data.id,(select id from t_setting  where code = 'MANDATORY_HRF_REQUIRED'),false,true);
     INSERT INTO t_countrysetting("id","country_id","setting_id","allowed","test")  values (nextval('t_countrysetting_id_seq'),country_data.id,(select id from t_setting  where code = 'VALIDATE_LEGAL_ATTACHMENTS'),false,true);
  END LOOP;

END$$;