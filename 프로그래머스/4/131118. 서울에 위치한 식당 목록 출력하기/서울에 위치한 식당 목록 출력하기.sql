# rest info =>  레스토랑 id, 이름, 음식타입, 조회수, 즐찾수, 주차장 유무, 주소, 전화번호
# rest review => 리뷰 id, 레스토랑 id, 멤버 id, 별점, 글, 작성일
# 서울에 위치 , 식당 Id, 이름, 음식종류, 즐찾수, 주소, 리뷰평균점수!
# 리뷰 평균점수는 소수점 세 번째 자리에서 반올림
# 결과는 평균점수 기준 내림차순, 즐찾수 내림차순

select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(avg(r.review_score),2) avg_score
from rest_info i
join rest_review r
on i.rest_id = r.rest_id
where substring(i.address,1,2)='서울' and i.rest_id = r.rest_id
group by r.rest_id
order by avg_score desc, i.favorites desc