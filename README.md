# Work-log
作業日報アプリ
現在の画面（`Work-log` プロジェクト）にあるコードや設定（`MyApplication` フォルダなど含む）を、GitHubのリポジトリ `Work-log` にアップロードして公開・プロフィールへ連携するための手順です。

下のターミナル（`@Rayleigh-610017 -> /workspaces/Work-log` と表示されている部分）で、以下のコマンドを**1行ずつコピー＆ペーストして実行**してください。

---

**1. 変更した全ファイルを保存対象に追加**

```bash
git add .

```

**2. 変更を記録（コミット）**

```bash
git commit -m "Add Work-log application files"

```

**3. GitHubへコードを送信（プッシュ）**

```bash
git push -u origin main

```

**4. リポジトリを公開（Public）に変更**

```bash
GITHUB_TOKEN= gh repo edit Work-log --visibility public --accept-visibility-change-consequences

```

---

実行完了後、[GitHubのプロフィールページ](https://github.com/Rayleigh-610017) の **「Customize your pins」** から `Work-log` にチェックを入れて保存すると、プロフィールにこのアプリが表示されます。