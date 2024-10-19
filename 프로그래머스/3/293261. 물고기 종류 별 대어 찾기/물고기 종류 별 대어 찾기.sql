-- 코드를 작성해주세요

select id, (select fish_name from fish_name_info n where n.fish_type=i.fish_type) as fish_name, length
from fish_info i
where i.fish_type in 
(
    select fish_type
    from fish_info
    group by fish_type
    having length=max(length)
)
;