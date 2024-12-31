select e.dept_id, d.dept_name_en, round(avg(e.sal)) avg_sal
from HR_EMPLOYEES e join HR_DEPARTMENT d on e.dept_id=d.dept_id
group by e.dept_id
order by avg_sal desc;