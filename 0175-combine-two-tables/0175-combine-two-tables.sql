# Write your MySQL query statement below
select p.firstName,p.lastName,A.city,A.state from person p Left join Address A on P.personId=A.personId