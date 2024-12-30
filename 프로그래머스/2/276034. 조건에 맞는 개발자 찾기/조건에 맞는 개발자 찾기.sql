select id, email, first_name, last_name 
from DEVELOPERS
where SKILL_CODE & (select sum(code) from SKILLCODES where name in ('python', 'c#'))
order by id