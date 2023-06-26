package bronze

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val octal = scanner.nextLine()

    val binary = octal
        // 8진수 한 자리씩 분리하여 2진수로 변환
        .map { it.digitToInt().toString(2) }
    // 2진수의 자릿수가 3 미만인 경우 앞에 0을 채움
        .map { it.padStart(3, '0') }
        // 각 자리의 2진수를 합쳐서 전체 2진수로 만듦
        .reduce { acc, s -> acc + s }

    // 출력
    if (binary == "0") {
        println("0")
    } else {
        // 첫 번째 1이 나올 때까지 0을 제거하여 출력
        println(binary.dropWhile { it == '0' })
    }
}
