# 고객정보 member_profile
# 식당의 리뷰정보 rest_review

# 리뷰를 가장많이 작성한 회원의 리뷰들 조회
# 결과는 리뷰 작성일 asc, 리뷰 텍스트 asc


select m.member_name, r.review_text, date_format(r.review_date,'%Y-%m-%d') review_date
from member_profile m 
left join rest_review r
on m.member_id = r.member_id
where m.member_id = (select member_id
                        from rest_review
                        group by member_id
                        order by count(*) desc
                        limit 1)
order by r.review_date, r.review_text