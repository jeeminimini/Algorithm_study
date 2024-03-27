-- 코드를 작성해주세요
select round(sum(IFNULL(length, 10)) / count(*), 2) AVERAGE_LENGTH from fish_info
