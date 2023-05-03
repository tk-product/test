update employee
set id = /* entity.id */0, name = /* entity.name */'0', age = /* entity.age */0, contents = /* entity.contents */'{}'::jsonb, version = /* entity.version */0 + 1
where id = /* entity.id */0 and version = /* entity.version */0
;