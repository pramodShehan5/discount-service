DO $$
DECLARE
   serviceprovider_id INTEGER;
BEGIN
serviceprovider_id = nextval('t_serviceprovider_id_seq');
INSERT INTO t_serviceprovider values (serviceprovider_id,'OB10','Tungsten Network',true,'Global e-invoice service provider');
INSERT INTO t_serviceproviderlegalattachment values (nextval('t_serviceproviderlegalattachment_id_seq'),serviceprovider_id,'LPP');
INSERT INTO t_serviceproviderlegalattachment values (nextval('t_serviceproviderlegalattachment_id_seq'),serviceprovider_id,'LGP');
INSERT INTO t_serviceproviderlegalattachment values (nextval('t_serviceproviderlegalattachment_id_seq'),serviceprovider_id,'LSP');
INSERT INTO t_serviceprovidersetting("id","serviceprovider_id","setting_id","allowed","test")  values (nextval('t_serviceprovidersetting_id_seq'),serviceprovider_id,(select id from t_setting  where code = 'WEB_INVOICE_ALLOWED'),true,true);
INSERT INTO t_serviceprovidersetting("id","serviceprovider_id","setting_id","allowed","test")  values (nextval('t_serviceprovidersetting_id_seq'),serviceprovider_id,(select id from t_setting  where code = 'ARCHIVE_ALLOWED'),true,true);
INSERT INTO t_serviceprovidersetting("id","serviceprovider_id","setting_id","allowed","test")  values (nextval('t_serviceprovidersetting_id_seq'),serviceprovider_id,(select id from t_setting  where code = 'INTRUSIVE_ENRICHMENT_ALLOWED'),true,true);
INSERT INTO t_serviceprovidersetting("id","serviceprovider_id","setting_id","allowed","test")  values (nextval('t_serviceprovidersetting_id_seq'),serviceprovider_id,(select id from t_setting  where code = 'MANDATORY_HRF_REQUIRED'),false,true);
INSERT INTO t_serviceprovidersetting("id","serviceprovider_id","setting_id","allowed","test")  values (nextval('t_serviceprovidersetting_id_seq'),serviceprovider_id,(select id from t_setting  where code = 'VALIDATE_LEGAL_ATTACHMENTS'),true,true);
END$$;