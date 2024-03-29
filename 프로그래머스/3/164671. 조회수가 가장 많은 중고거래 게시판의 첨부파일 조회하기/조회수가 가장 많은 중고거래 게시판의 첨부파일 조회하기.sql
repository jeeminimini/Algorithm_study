-- 코드를 입력하세요
SELECT concat("/home/grep/src/",b.board_id, "/",a.file_id,a.file_name,a.file_ext) as file_path from USED_GOODS_FILE a left join USED_GOODS_BOARD b on a.board_id = b.board_id
where b.views = (select max(views) from used_goods_board)
order by a.file_name desc
