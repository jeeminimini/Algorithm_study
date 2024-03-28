-- 코드를 작성해주세요
select sum(c.score) score, c.emp_no, a.emp_name, a.position, a.email from hr_grade c
-- left join hr_department b on a.dept_id = b.dept_id
left join HR_EMPLOYEES a on a.emp_no = c.emp_no
group by c.emp_no -- a.emp_name, a.position, a.email
order by score desc
limit 1