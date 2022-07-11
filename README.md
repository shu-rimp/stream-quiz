# stream-quiz
예제를 통한 JAVA Stream API 연습

MangKyu님이 제작한 문제입니다. [이용방법](source/originalRM.MD) 

<br>

# Stream 문제
[문제1](#문제1) | [문제2](#문제2) | [문제3](#문제3) | [문제4](#문제4) | [문제5](#문제5) | [문제6](#문제6)

<br>

## 문제1
[목차로 이동](#stream-quiz)


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

[전체풀이 소스코드](src/main/java/com/mangkyu/stream/Quiz1/Quiz1.java)

### 문제 1.1 풀이
위와 같은 데이터를 조회하여 각 취미를 선호하는 인원이 몇 명인지 계산하여라.

```java
public Map<String, Integer> quiz1() throws Exception {
    List<String[]> user = readCsvLines();

    return user.stream()
            .map(t -> t[1].replace(" ", ""))
            .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
            // toMap(KeyMapper, ValueMapper, mergeFunction)
            .collect(Collectors.toMap(key -> key, val -> 1, (oldVal, newVal) -> newVal += oldVal));        
} // quiz1
```

```text
두번째 열에 취미 데이터가 있으므로 1번째 인덱스로 맵핑한다.
맨 앞에 공백이 있으므로 replace()를 사용해 공백을 제거한다.
취미가 :를 기준으로 여러개 나열되어있으므로, String클래스의 split메소드를 사용해 콜론을 기준으로 구분하고,
flatMap으로 차원을 낮춰준다.
마지막으로 Collectors의 toMap함수를 사용해 맵객체로 만들어 리턴한다.

toMap함수의 매개변수로는 KeyMapper, ValueMapper, mergeFunction을 가지는데,
키와 값을 각각 매핑할 수 있고, 마지막 mergeFunction을 사용해 동일한 키를 가지는 값에 대해 어떤 처리를 할 것인지를
명시할 수 있다.

초기 value값을 1로 지정하고 해당 키에 새로운 값이 들어왔을 때, 
기존 값에 더한 값으로 지정해주면 취미를 선호하는 인원 수를 구할 수 있다.
```

### 문제 1.2 풀이
위와 같은 데이터를 조회하여 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.

```java
public Map<String, Integer> quiz2() throws Exception {
    List<String[]> user = readCsvLines();

    return user.stream()
            .filter(name -> name[0].substring(0, 1).equals("정"))
//        		.filter(name -> name[0].startsWith("정")) 예시답안
            .map(t -> t[1].replace(" ", ""))
            .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
            .collect(Collectors.toMap(key -> key, val -> 1, (oldVal, newVal) -> ++newVal));
} // quiz2
```

```text
첫번째 열에 이름 데이터가 있으므로 0번째 인덱스로 찾는다.
정씨성을 가진 인원을 먼저 거른 후 인원 수를 계산하는게 효율적이므로, 먼저 filter()를 사용한다.
substring으로 첫번째 글자만 자른 후 그 값이 "정"이라면 거르는 조건으로 작성했는데,
제시된 답안에서는 startsWith()를 사용했다.

필터로 거른 후에는 문제 1.1과 동일하게 취미를 분리해서 매핑한 후 toMap()함수로 인원 수를 세면 된다.
```

### 문제 1.3 풀이
위와 같은 데이터를 조회하여 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.

```java
public int quiz3() throws Exception {
    List<String[]> user = readCsvLines();

    return user.stream()
            .map(line -> countLike(line[2], "좋아", 0))
            .reduce(0, Integer::sum);
} // quiz3
```

```text
처음에는 단순히 필터에 contains()를 사용해 "좋아"가 있는 데이터만 걸러서 카운트했는데,
다시보니 한 라인에 "좋아"가 여러번 있는 경우가 있어서 오답이었다.

"좋아"가 등장한 횟수를 세서 정수값으로 매핑한 후 reduce()를 사용해 더해야한다.

제시된 답안에서는 "좋아"가 등장한 횟수를 계산하는 방법으로 countLike메소드를 따로 구현한 후 사용했다.
매개변수로 전체 문자열, 찾을 문자열, 인덱스값을 넣어준 후 indexOf()를 사용해서 그 값이 1 이상이면(해당 문자열이 있으면)
기존 인덱스 + 해당문자열의 길이를 다시 매개변수로 넣어 재귀호출한다.

이렇게 하면 등장한 횟수를 리턴받을 수 있다.
해당 메소드의 리턴값으로 데이터를 매핑한다음, reduce()를 이용해 전체 데이터를 더하면 된다.
```

<br>

## 문제2
[목차로 이동](#stream-quiz)

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
[목차로 이동](#stream-quiz)

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
[목차로 이동](#stream-quiz)

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
[목차로 이동](#stream-quiz)

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
[목차로 이동](#stream-quiz)

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

