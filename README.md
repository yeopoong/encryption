# Encryption

256 bit 키를 사용하려면, JCE Unlimited Strength Jurisdiction Policy Files 을 별도로 다운받아 적용하여야 한다.
```
http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip
```

다운받은 파일들을(local_policy.jar, US_export_policy.jar) $JAVA_HOME/jre/lib/security 에 복사해 넣는다.

