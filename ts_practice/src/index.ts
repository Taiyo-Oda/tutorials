
const greeting: string = "Hellow";
const target: string = "World!";
console.log(greeting + target);

const width1 = 5;
const width2 = 8;
const height: number = 3;
const area = (width1 + width2) * height/2;
// 19.5と出力される（numberでは整数と少数を区別しない）
console.log(area);

// 数値リテラル(10進数以外)
const binary = 0b1010; // 2進数
const octal = 0o755; // 8進数
const hexadecimal = 0xff; // 16進数
console.log(binary,octal,hexadecimal);
// 指数標記の数値リテラル
const big = 1e8; // 1*10の8乗
const small = 4e-5; // 4*10の-5乗
console.log(big,small);
// 間に_を挟んだ数値リテラル
const million = 1_000_000; // = 1000000
console.log(million);
/* TSにおける数値はIEEE754倍精度浮動小数点数である
 * TSの数値は64ビットで表される少数型である(Javaのdouble型に相当する)
 * ポイント１：数値の精度は53bitである
 * 53bitに収まらない大きさの整数を扱おうとした場合、下の桁から精度が落ちていく（２進数で54桁以上の数値を扱おうとすると計算誤差が生じる）
 */

