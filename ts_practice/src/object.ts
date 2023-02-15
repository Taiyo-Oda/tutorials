import { createInterface } from "readline";

const rl = createInterface({
  input: process.stdin,
  output: process.stdout
});

// プロパティ名を動的に決定することもできる
const propName = "foo";
const obj = {
  [propName] : 123,
  prop2 : 456
}
// objectがconstで宣言されている場合でもオブジェクトの中身（プロパティ）を書き換えることはできる
obj.prop2 = 789;

// スプレット構文(プロパティを別のオブジェクトからコピーする)
const obj1 = {
  bar : 456,
  buz : 789
};
const obj2 = {
  foo : 123,
  ...obj1
};
console.log(obj2);

rl.question('名前を入力してください', (name) => {
  // オブジェクト内で論理演算を行える
  const input = name;
  const user = {
    name : input ? input : "名無し",
    age : 20
  };
  // プロパティ名===変数名であれば変数名を省略できる
  const name2 = input ? input : "名無し";
  const user2 = {
    name2,
    age2 : 20
  };
  rl.close;
});
