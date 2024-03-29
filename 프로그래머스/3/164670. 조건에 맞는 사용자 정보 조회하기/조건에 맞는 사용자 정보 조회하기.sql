-- 코드를 입력하세요
SELECT a.writer_id, b.nickname, concat(b.city, " ", b.street_address1, " ", b.street_address2) as "전체주소", 
concat_ws("-",left(b.tlno,3), substring(b.tlno, 4, 4), right(b.tlno, 4)) as "전화번호"
from used_goods_board a left join used_goods_user b on a.writer_id = b.user_id
group by a.writer_id having count(a.writer_id) >= 3
order by a.writer_id desc