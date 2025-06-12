CREATE TABLE CAR_TBL
(SORT       VARCHAR2(200) NOT NULL,
 TYPE       VARCHAR2(200) NOT NULL,
 NUM_PLATE  VARCHAR2(200) NOT NULL,
 PRICE      NUMBER            NULL,
 MILE       NUMBER            NULL,
 INSURANCE  DATE              NULL,
 ISEXIST    NUMBER            NULL,
 ACCIDENT   NUMBER            NULL);
 
 SELECT *
 FROM CAR_TBL;
 
 CREATE TABLE  DRIVE_LIST
 (SORT       VARCHAR2(200),
  NUM_PLATE  VARCHAR2(200) NOT NULL,
  C_NAME     VARCHAR2(100)         ,
  D_MILE     NUMBER                ,
  ISEXIST    NUMBER            ,
  ACCIDENT   NUMBER            NULL);
  
 SELECT *
 FROM DRIVE_LIST;
 
 SELECT *
 FROM CAR_TBL;
 
 select * from car_tbl order by 8 desc;  
 
 
 
 INSERT INTO CAR_TBL
 VALUES ('GV70','대형','185허 9966',130000000,51000,'2025-12-31',1,0);

 
 select  d.sort 차종, 
				 c.type AS "크기",
				 d.num_plate AS "번호판",
				 c.mile + sum(d.d_mile)  AS "총주행거리",
				 c.accident + sum(d.accident) As "사고이력",
				decode(c.type,'대형',300000,'소형',150000) + (sum(d.accident)+c.accident)*100000 AS "보험료",
			    c.price  - (sum(d.accident) + c.accident) * 100000 - (sum(d.d_mile) + c.mile) * (sum(d.accident) + c.accident) * 88 "현재가치"
from drive_list d join car_tbl c
                 on d.num_plate = c.num_plate
WHERE SUBSTR(d.num_plate,-4,4) = 3121
GROUP BY d.sort,c.type,d.num_plate,c.mile,c.accident,c.price;

SELECT C_Name,
       COUNT(C_NAME),
       SUM(D_MILE),
       SUM(ACCIDENT)
FROM   DRIVE_LIST
WHERE  C_NAME = '김영범'
GROUP BY C_NAME;

SELECT c.SORT,
       c.NUM_PLATE,
       c.MILE + sum(d.D_MILE)
FROM CAR_TBL c JOIN DRIVE_LIST d
                on(c.num_plate = d.num_plate)
GROUP BY c.sort, c.num_plate, c.mile
Order by 3 DESC;

