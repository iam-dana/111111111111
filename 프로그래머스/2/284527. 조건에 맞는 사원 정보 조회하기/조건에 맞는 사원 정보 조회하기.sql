-- 코드를 작성해주세요
select s.score, h.emp_no, h.emp_name, h.position, h.email
from hr_employees h join (select emp_no, sum(score) score from hr_grade
group by emp_no) s on h.emp_no=s.emp_no
order by s.score desc limit 1;
