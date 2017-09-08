create table "t_setting"
("id" SERIAL NOT NULL PRIMARY KEY,
"code" VARCHAR(40) NOT NULL,
"default" BOOLEAN NOT NULL
);

create table "t_configuration"
("id" SERIAL NOT NULL PRIMARY KEY,
"code" VARCHAR(40) NOT NULL,
"default" BOOLEAN NOT NULL
);

create table "t_country"
("id" SERIAL NOT NULL PRIMARY KEY,
"code" VARCHAR(10) NOT NULL UNIQUE,
"name" VARCHAR(70) NOT NULL,
"active" BOOLEAN default true,
"white_listed" BOOLEAN default true,
"fully_compliant" BOOLEAN NOT NULL,
"description" TEXT
);

create table "t_countrydigsigtype"
("id" SERIAL NOT NULL PRIMARY KEY,
"country_id" INTEGER NOT NULL,
"digsigtype" VARCHAR(20) NOT NULL,
constraint "country_digsig_type_country_fk" foreign key("country_id") references "t_country"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_countrylegalattachment"
("id" SERIAL NOT NULL PRIMARY KEY,
"country_id" INTEGER NOT NULL,
"attachmenttype" VARCHAR(20) NOT NULL,
constraint "country_legal_attachment_country_fk" foreign key("country_id") references "t_country"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_countryschematron"
("id" SERIAL NOT NULL PRIMARY KEY,
"country_id" INTEGER NOT NULL,
"uri" TEXT NOT NULL,
"description" TEXT,
constraint "country_schematron_country_fk" foreign key("country_id") references "t_country"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_countrysetting"
("id" SERIAL NOT NULL PRIMARY KEY,
"country_id" INTEGER NOT NULL,
"setting_id" INTEGER NOT NULL,
"allowed" BOOLEAN NOT NULL,
"test" BOOLEAN NOT NULL,
constraint "country_setting_country_fk" foreign key("country_id") references "t_country"("id") MATCH SIMPLE ON DELETE CASCADE,
constraint "country_setting_setting_fk" foreign key("setting_id") references "t_setting"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_countryconfiguration"
("id" SERIAL NOT NULL PRIMARY KEY,
"country_id" INTEGER NOT NULL,
"configuration_id" INTEGER NOT NULL,
"enabled" BOOLEAN NOT NULL,
constraint "country_configuration_country_fk" foreign key("country_id") references "t_country"("id") MATCH SIMPLE ON DELETE CASCADE,
constraint "country_configuration_configuration_fk" foreign key("configuration_id") references "t_configuration"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_serviceprovider"
("id" SERIAL NOT NULL PRIMARY KEY,
"intermediator_id" VARCHAR(70) NOT NULL UNIQUE,
"name" VARCHAR(70) NOT NULL,
"active" BOOLEAN default true,
"description" TEXT
);

create table "t_serviceproviderdigsigtype"
("id" SERIAL NOT NULL PRIMARY KEY,
"serviceprovider_id" INTEGER NOT NULL,
"digsigtype" VARCHAR(20) NOT NULL,
constraint "service_provider_digsig_type_service_provider_fk" foreign key("serviceprovider_id") references "t_serviceprovider"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_serviceproviderlegalattachment"
("id" SERIAL NOT NULL PRIMARY KEY,
"serviceprovider_id" INTEGER NOT NULL,
"attachmenttype" VARCHAR(20) NOT NULL,
constraint "service_provider_legal_attachment_service_provider_fk" foreign key("serviceprovider_id") references "t_serviceprovider"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_serviceproviderschematron"
("id" SERIAL NOT NULL PRIMARY KEY,
"serviceprovider_id" INTEGER NOT NULL,
"uri" TEXT NOT NULL,
"description" TEXT,
constraint "service_provider_schematron_service_provider_fk" foreign key("serviceprovider_id") references "t_serviceprovider"("id") MATCH SIMPLE ON DELETE CASCADE
);

create table "t_serviceprovidersetting"
("id" SERIAL NOT NULL PRIMARY KEY,
"serviceprovider_id" INTEGER NOT NULL,
"setting_id" INTEGER NOT NULL,
"allowed" BOOLEAN NOT NULL,
"test" BOOLEAN NOT NULL,
constraint "service_provider_setting_service_provider_fk" foreign key("serviceprovider_id") references "t_serviceprovider"("id") MATCH SIMPLE ON DELETE CASCADE,
constraint "setting_fk" foreign key("setting_id") references "t_setting"("id") MATCH SIMPLE ON DELETE CASCADE
);