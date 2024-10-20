# java-calculator-precourse

## 목차

1. [학습 목표](#학습-목표)
2. [프로젝트 관리](#프로젝트-관리)
3. [요구 사항](#요구-사항)

## 학습 목표

- Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다.
- 교육 분야에 맞는 프로그래밍 언어를 사용하여 간단한 문제를 해결한다.

## 프로젝트 관리

"Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다"는 학습 목표 수행을 위해,
프리코스 중 준수할 프로젝트 관리 규칙을 정리했습니다.

> 💡 **프로젝트 설정 및 관리에 대한 자세한 내용은 [여기](docs/SET_UP.md)에서 확인할 수 있습니다.**

## 요구 사항

> 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 **추가**한다.<br>
> **Git의 커밋 단위**는 앞 단계에서 README.md에 정리한 **기능 목록 단위로 추가**한다.

**과제 진행 요구 사항**에 따라 첫 Commit(docs: 요구사항 명세 및 Docs 작성) 이후,<br>
후술할 기능 목록 각각을 단위로 Commit한다.

> 📝 **과제에 대한 상세 설명은 [여기](docs/ASSIGNMENT.md)에서 확인할 수 있습니다.**

프리코스 1주차 과제는 "문자열 덧셈 계산기"입니다.<br>
해당 과제의 기능을 분석한 "기능 목록"은 다음과 같습니다:

### 📝 기능 목록

- [x] | 문자열을 입력 받는다
- [x] | 구분자를 이용해 문자열 분리한다
- [x] | 분리된 숫자 더한다
- [x] | 커스텀 구분자 지정한다
- [x] | 잘못된 입력에 대한 IllegalArgumentException 예외 처리한다
- [x] | 결과를 출력한다

### ⚠️ 예외 처리 상세

- 잘못된 입력에 대한 IllegalArgumentException 예외 처리
    - [x] | 잘못된 구분자 형식 처리 시  (ex. 12s3)
    - [x] | 커스텀 구분자가 '//'으로 시작되지 않을 시 (ex. asd\n12:12)
    - [x] | 커스텀 구분자를 둘 이상의 연속된 문자로 지정할 시 (ex. //ss\n1s2,3)
    - [x] | 커스텀 구분자에 숫자가 포함될 시 (ex. //1\n212)
    - [ ] | ~~\을 커스텀 구분자로 지정할 시~~ (ex. //\\n2\2)
      <br>*이는 예외가 아닌 경우로 정정한다*

### 🧪 테스트 확인

*기능 테스트*

- [x] | 1. 문자열 덧셈
- [x] | 2. 커스텀 구분자 사용

*예외 테스트*

- [x] | 1. 잘못된 구분자 형식 처리 시 (= 음수를 입력할 시)
- [x] | 2. 커스텀 구분자가 '//'으로 시작되지 않을 시
- [x] | 3. 커스텀 구분자를 둘 이상의 연속된 문자로 지정할 시
- [x] | 4. 커스텀 구분자에 숫자가 포함될 시

---

[🔝 맨 위로 돌아가기](#java-calculator-precourse)