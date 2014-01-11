package com.corvustec.signture.main;

import java.security.KeyStore;
import java.security.KeyStoreException;

public abstract interface KeyStoreProvider
{
  public abstract KeyStore getKeystore(char[] paramArrayOfChar)
    throws KeyStoreException;
}