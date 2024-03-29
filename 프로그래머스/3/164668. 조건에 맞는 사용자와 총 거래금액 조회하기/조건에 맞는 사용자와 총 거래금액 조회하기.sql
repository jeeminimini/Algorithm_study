-- 코드를 입력하세요
SELECT a.writer_id, b.nickname, sum(price) as total_sales from used_goods_board a left join used_goods_user b on a.writer_id = b.user_id
where a.status = 'DONE' 
group by a.writer_id having sum(price) >= 700000
order by total_sales