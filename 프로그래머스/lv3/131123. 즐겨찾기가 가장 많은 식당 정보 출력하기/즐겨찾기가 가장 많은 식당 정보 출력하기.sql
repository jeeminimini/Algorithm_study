-- 코드를 입력하세요
SELECT R.FOOD_TYPE, R.REST_ID, R.REST_NAME, R.FAVORITES
FROM (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS T
JOIN REST_INFO AS R
ON T.FOOD_TYPE = R.FOOD_TYPE
WHERE R.FAVORITES = T.MAX
ORDER BY R.FOOD_TYPE DESC