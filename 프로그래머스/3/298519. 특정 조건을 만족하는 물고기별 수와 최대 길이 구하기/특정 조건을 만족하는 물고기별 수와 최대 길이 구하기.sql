-- 코드를 작성해주세요

# select count(id) fish_count, 
# (select (sum(length)+(select 10*count(id) from fish_info where length is null and fish_type = f.fish_type)
# )/count(id) from fish_info where fish_type=f.fish_type) max_length, fish_type
# from fish_info f
# group by fish_type
# having max_length > 33
# order by fish_type asc;

select count(id) fish_count, max(length) max_length, fish_type
from fish_info f
group by fish_type
having (select (sum(length)+(select 10*count(id) from fish_info where length is null and fish_type = f.fish_type)
)/count(id) from fish_info where fish_type=f.fish_type) > 33
order by fish_type asc;