-- 코드를 입력하세요

# select YEAR(sales_date) YEAR, MONTH(sales_date) MONTH, count(o.user_id) PUCHASED_USERS, round((count(o.user_id)/(select count(*) from user_info
# where year(joined)=2021)), 1) PUCHASED_RATIO
select YEAR(sales_date) YEAR, MONTH(sales_date) MONTH, count(distinct o.user_id) PUCHASED_USERS, round((count(distinct o.user_id)/(select count(*) from user_info where year(joined)=2021)), 1) PUCHASED_RATIO
from online_sale o join (select user_id, joined from user_info
where year(joined)=2021) u on o.user_id=u.user_id
group by year, month
order by year, month;

# select *
# from online_sale o join (select user_id, joined from user_info
# where year(joined)=2021) u on o.user_id=u.user_id;



