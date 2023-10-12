#도서정보 book{bookid, 카테고리, 작가id, 가격, 출판일}
#저자정보 author{authorid, 작가이름}

select b.book_id BOOK_ID, a.author_name AUTHOR_NAME, date_format(b.published_date,"%Y-%m-%d") PUBLISHED_DATE
from book b
join author a
on b.author_id = a.author_id
where b.category = '경제'
order by PUBLISHED_DATE
