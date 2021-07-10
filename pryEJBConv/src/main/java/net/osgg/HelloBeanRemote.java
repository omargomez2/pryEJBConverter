package net.osgg;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
    public String getMessage();
}