# select 게시글 제목, 게시글 id, 댓글 id, 작성자 id, 내용, 작성일
# from 2개
# 댓글작성일 desc, 게시글 제목 desc

select b.title title, b.board_id board_id, r.reply_id reply_id, r.writer_id writer_id, r.contents contents, date_format(r.created_date,'%Y-%m-%d') created_date
from used_goods_board b, used_goods_reply r
where year(b.created_date) = '2022' and month(b.created_date) = '10' and b.board_id = r.board_id
order by created_date, title 