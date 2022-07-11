# stream-quiz
예제를 통한 JAVA Stream API 연습

MangKyu님이 제작한 문제입니다. [이용방법](source/originalRM.MD) 

<br>

# Stream 문제
[문제1](#문제1) | [문제2](#문제2) | [문제3](#문제3) | [문제4](#문제4) | [문제5](#문제5) | [문제6](#문제6)

<br>

## 문제1
[top](#top)

아래와 같은 User.csv가 있다고 할 때, 아래의 CSV 데이터를 조회하여 아래와 같은 결과를 출력한다고 하자.
```text
//User.csv
이름, 취미, 소개
김프로, 축구:농구:야구, 구기종목 좋아요
정프로, 개발:당구:축구, 개발하는데 뛰긴 싫어
앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아
죠르디, 스포츠댄스:개발, 개발하는 죠르디 좋아
박프로, 골프:야구, 운동이 좋아요
정프로, 개발:축구:농구, 개발도 좋고 운동도 좋아
```

### 문제 1.1
위와 같은 데이터를 조회하여 각 취미를 선호하는 인원이 몇 명인지 계산하여라.

### 문제 1.2
위와 같은 데이터를 조회하여 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.

### 문제 1.3
위와 같은 데이터를 조회하여 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.

<br>

## 문제1 풀이
[전체 소스코드](src/main/java/com/mangkyu/stream/Quiz1/Quiz1.java)

### 문제 1.1

### 문제 1.2

### 문제 1.3

<br>

## 문제2
[top](#top)

아래와 같은 데이터가 저장된 리스트가 있다고 하자.
```java
private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");
```



### 문제 2.1
List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
ex) ("T", 1), ("a", 2) ...

### 문제 2.2
List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
ex) ["Hello", "a", "Island", "b"] -> “HI”

<br>

## 문제2 풀이
[전체 소스코드](src/main/java/com/mangkyu/stream/Quiz2/Quiz2.java)

### 문제 2.1

### 문제 2.2

<br>

## 문제3
[top](#top)

```java
private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
private static final List<Integer> numbers2 = Arrays.asList(3, 4);
```



### 문제 3.1
위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
ex) numbers1 = [1,2,3], numbers2 =  [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]

<br>

### 문제 3.2
위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
ex) numbers1 = [1,2,3], numbers2 =  [3,4] -> 12

<br>

## 문제3 풀이
[전체 소스코드](src/main/java/com/mangkyu/stream/Quiz3/Quiz3.java)

### 문제 3.1

### 문제 3.2

<br>

## 문제4
[top](#top)

아래와 같은 데이터를 갖는 거래자와 거래 내역 클래스가 있다고 하자.
(생성자 및 Getter, Setter 등은 생략)

```java
public class Trader {
    private String name;
    private String city;
}

public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
```


또한 데이터는 아래와 같이 초기화되어 있다.

```java
public void init() {
    Trader kyu = new Trader("Kyu", "Seoul");
    Trader ming = new Trader("Ming", "Gyeonggi");
    Trader hyuk = new Trader("Hyuk", "Incheon");
    Trader hyuk = new Trader("Hyuk", "Seoul");
    transactions = Arrays.asList(
            new Transaction(kyu, 2019, 30000),
            new Transaction(kyu, 2020, 12000),
            new Transaction(ming, 2020, 40000),
            new Transaction(ming, 2020, 7100),
            new Transaction(hyuk, 2019, 5900),
            new Transaction(hwan, 2020, 4900)
    );
}
```


### 문제 4.1

2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.



### 문제 4.2
거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열하라.



### 문제 4.3
서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.



### 문제 4.4
모든 거래자의 이름을 순서대로 정렬하라.



### 문제 4.5
부산에 거래자가 있는지를 확인하라.



### 문제 4.6
서울에 거주하는 거래자의 모든 거래 내역을 구하라.



### 문제 4.7
모든 거래 내역중에서 최댓값과 최솟값을 구하라.
단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용하라.


<br>

## 문제4 풀이
[전체 소스코드](src/main/java/com/mangkyu/stream/Quiz4/Quiz4.java)

### 문제 4.1

### 문제 4.2

### 문제 4.3

### 문제 4.4

### 문제 4.5

### 문제 4.6

### 문제 4.7

<br>

## 문제5
[top](#top)

### 문제 5.1
문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 모든 문자열의 길이를 더한 결과를 출력하여라.

<br>

### 문제 5.2
문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 문자열 중에서 가장 긴 것의 길이를 출력하시오.

<br>

### 문제 5.3
임의의 로또번호(1~45)를 정렬해서 출력하시오.

<br>

### 문제 5.4
두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.

<br>

## 문제5 풀이
[전체 소스코드](src/main/java/com/mangkyu/stream/Quiz5/Quiz5.java)

### 문제 5.1

### 문제 5.2

### 문제 5.3

### 문제 5.4

<br>


## 문제6
[top](#top)

아래와 같은 학생 클래스가 있다고 하자.
(생성자 및 Getter 등은 생략)

```java
public class Student {

    private String name;
    private boolean isMale; // 성별
    private int hak; // 학년
    private int ban; // 반
    private int score;

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }
}
```


또한 데이터는 Student[] stuArr에 저장되어 있다.

### 문제 6.1

stuArr에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여라.
(Boolean, List<Student>)

### 문제 6.2
각 반별 총점을 학년 별로 나누어 구하여라
(Map<Integer, Map<Integer, Integer>>)

<br>

## 문제6 풀이
[전체 소스코드](src/main/java/com/mangkyu/stream/Quiz6/Quiz6.java)

### 문제 6.1

### 문제 6.2

