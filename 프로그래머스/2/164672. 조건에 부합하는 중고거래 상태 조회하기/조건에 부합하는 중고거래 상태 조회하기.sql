-- 코드를 입력하세요
SELECT BOARD_ID,WRITER_ID,TITLE,PRICE,
case 
    when STATUS = 'SALE' 
    then '판매중'
    when STATUS = 'reserved' 
    then '예약중'
    else '거래완료'
end as STATUS
from used_goods_board
where date_format(CREATED_DATE, "%Y-%m-%d") = '2022-10-05'
order by board_id desc