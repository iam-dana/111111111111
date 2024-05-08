-- 코드를 작성해주세요

select YEAR(YM) YEAR, ROUND(SUM(PM_VAL1)/COUNT(PM_VAL1),2) PM10, ROUND(SUM(PM_VAL2)/COUNT(PM_VAL2),2) 'PM2.5'
from AIR_POLLUTION 
where location1='경기도' and location2='수원'
group by YEAR(YM)
order by year;