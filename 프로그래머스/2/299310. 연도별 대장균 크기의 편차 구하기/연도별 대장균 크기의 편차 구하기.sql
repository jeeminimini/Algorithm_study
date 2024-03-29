-- 코드를 작성해주세요
select b.year, b.maxi - a.size_of_colony as year_dev, a.id from ecoli_data a, 
    (select year(differentiation_date) as year, max(size_of_colony) as maxi from ecoli_data
        group by year) b
where year(a.differentiation_date) = b.year
order by b.year, year_dev 