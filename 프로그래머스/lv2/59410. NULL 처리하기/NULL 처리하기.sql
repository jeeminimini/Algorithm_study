-- 코드를 입력하세요
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME,
-- CASE WHEN NAME IS NULL THEN "No name"
--    ELSE NAME
--    END AS NAME,
SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC