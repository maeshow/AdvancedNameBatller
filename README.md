## NameBattler

「名前」からキャラクターを生成して、戦わせるゲーム

## Overview

1. NameBattler初級編を改良したもの
2. 素早さを追加
3. 職業（魔法使い）を追加
4. 職業（僧侶）を追加
5. 職業（暗殺者）を追加

## Detail

### 職業

| 職業 | HP | MP | STR | DEF | LUCK | AGI |
| --- | --- | --- | --- | --- | --- | --- |
| 戦士 | 100 ~ 300 | 0 | 30 ~ 100 | 30 ~ 100 | 1 ~ 100 | 1 ~ 50 |
| 魔法使い | 50 ~ 150 | 30 ~ 80 | 1 ~ 50 | 1 ~ 50 | 1 ~ 100 | 20 ~ 60 |
| 僧侶 | 80 ~ 200 | 20 ~ 50 | 10 ~ 70 | 10 ~ 70 | 1 ~ 100 | 20 ~ 60 |
| 暗殺者 | 50 ~ 150 | 20 ~ 50 | 30 ~ 80 | 1 ~ 25 | 1 ~ 100 | 50 ~ 100 |

### 魔法

| 名称 | 職業 | 消費MP | 効果 |
| --- | --- | --- | --- |
| ファイア | 魔法使い | 10 | 敵に10 ~ 30の防御無視ダメージ |
| サンダー | 魔法使い | 20 | 敵に10 ~ 30の防御無視ダメージ |
| ヒール | 僧侶 | 20 | HPを50回復 |
| パライズ | 僧侶・暗殺者 | 10 | まひの効果を与える　麻痺：20%の確率で行動不能 |
| ポイズン | 僧侶・暗殺者 | 10 | 毒状態にする　毒：毎ターン20のダメージを与える |