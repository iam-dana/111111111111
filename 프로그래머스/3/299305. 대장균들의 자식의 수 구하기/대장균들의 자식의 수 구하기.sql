-- 코드를 작성해주세요

select id, 
(select count(id) from ecoli_data e2
 where e1.id=e2.parent_id) 
as child_count 
from ecoli_data e1
order by id;