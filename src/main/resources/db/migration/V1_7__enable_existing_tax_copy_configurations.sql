update t_countryconfiguration set enabled = true where country_id = (select id from t_country where code = 'ES');
update t_countryconfiguration set enabled = true where country_id = (select id from t_country where code = 'ZA');
update t_countryconfiguration set enabled = true where country_id = (select id from t_country where code = 'PT');