SELECT * FROM countries;

SELECT * FROM languages;


SELECT countries.name ,languages.language,languages.percentage
FROM countries
JOIN languages
ON countries.id=languages.country_id
WHERE languages.language='Slovene'
ORDER BY languages.percentage DESC;

SELECT countries.name,count(cities.id) AS sum_of_cities
FROM cities
JOIN countries
ON cities.country_id=countries.id
GROUP BY cities.country_id
ORDER BY sum_of_cities DESC;

SELECT cities.name,cities.population,countries.id
FROM cities
JOIN countries
ON cities.country_id=countries.id
WHERE countries.name='Mexico'
AND cities.population>500.000
ORDER BY cities.population DESC ;

SELECT country.Name , countrylanguage.Language , countrylanguage.Percentage 
FROM countrylanguage 
JOIN country 
ON countrylanguage.CountryCode = country.Code 
WHERE (countrylanguage.Percentage > 89 ) 
ORDER BY countrylanguage.Percentage DESC;

SELECT countries.name , countries.surface_area , countries.population 
FROM countries
WHERE countries.population>100000 
AND countries.surface_area<501 ;


SELECT countries.name , countries.government_form  , countries.capital , countries.life_expectancy
FROM  countries 
WHERE countries.government_form='constitutional monarchy'
AND countries.capital>200 
AND countries.life_expectancy>75 ;


SELECT countries.name , cities.name , cities.district, cities.population
FROM countries
JOIN cities 
ON  cities.country_id = countries.id
WHERE  countries.name ='Argentina'
AND cities.district= 'Buenos Aires'
AND cities.population >500000;


SELECT countries.region , COUNT(countries.id) AS countries
 FROM countries 
 GROUP BY countries.region 
 ORDER BY countries DESC ;



