-- 코드를 입력하세요
-- SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- JOIN (SELECT CAR_ID 
--      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--      GROUP BY CAR_ID
--      HAVING COUNT(MONTH(START_DATE) >= 8 AND MONTH(START_DATE) <= 10) >= 5
--      ) AS I
-- ON C.CAR_ID = I.CAR_ID
-- WHERE MONTH(START_DATE) BETWEEN 8 AND 10
-- GROUP BY MONTH(START_DATE), CAR_ID
-- HAVING COUNT(CAR_ID) >= 5
-- ORDER BY MONTH(START_DATE)

select month(start_date) as month, car_id, count(history_id) as records
from car_rental_company_rental_history
where car_id in (select car_id
                from car_rental_company_rental_history
                where (date_format(start_date, '%Y-%m') between '2022-08' and '2022-10')
                group by car_id
                having count(car_id) >= 5)
                and (date_format(start_date, '%Y-%m') between '2022-08' and '2022-10')
group by month, car_id
having records > 0
order by month, car_id desc