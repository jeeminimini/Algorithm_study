-- 코드를 작성해주세요
select a.DEPT_ID, b.dept_name_en, round(avg(a.sal)) avg_sal from hr_employees a left join hr_department b on a.DEPT_ID = b.DEPT_ID
group by a.DEPT_ID
order by avg_sal desc