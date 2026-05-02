## Lessons Learned

### Not able to git ignore .idea directory things

* That happens because those files were already tracked by Git before you added .idea/ to .gitignore.
* Run this from your project root for your ignore file:

```shell
git rm --cached .idea/encoding.xml
git rm --cached .idea/misc.xml
git rm --cached .idea/vcs.xml
```