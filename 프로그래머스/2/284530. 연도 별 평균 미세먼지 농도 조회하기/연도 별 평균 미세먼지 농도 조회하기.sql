-- 코드를 작성해주세요
select year(YM) as YEAR, round(avg(PM_VAL1), 2) as pm10, round(avg(PM_VAL2), 2) as 'pm2.5' from AIR_POLLUTION
where location2 = '수원'
group by YEAR
order by YEAR 
