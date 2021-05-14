create extension if not exists pgcrypto;

update system_control_requirements.usr set password = crypt(password, gen_salt('bf', 8));