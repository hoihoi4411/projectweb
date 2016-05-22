/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.fpt.project.bo;

import java.util.*;

/**
 *
 * @author MyPC
 */
public class Language {

    /**
     * This is enum Locate
     */
    public enum Locate {
        /**
         * This is English language
         */
        EN,
        /**
         * This is Vietnamese
         */
        VI;
    }

    /**
     * This is enum key get content in properties
     */
    public enum LangKey {
        /**
         * This is variable ACCOUNT_NUMBER
         */
        ACCOUNT_NUMBER,
        /**
         * /**
         * This is variable ACCOUNT_NUMBER_REQUIRE
         */
        ACCOUNT_NUMBER_REQUIRE,
        /**
         * This is variable PASSWORD
         */
        PASSWORD,
        /**
         * This is variable PASSWORD_REQIRE
         */
        PASSWORD_REQIRE,
        /**
         * This is variable CAPTCHA
         */
        CAPTCHA,
        /**
         * This is variable ENTER_CAPTCHA
         */
        ENTER_CAPTCHA,
        /**
         * This is variable CAPTCHA_INCORRECT
         */
        CAPTCHA_INCORRECT;
    }

    /**
     * This is variable accountNumber
     */
    private String accountNumber;
    /**
     * This is variable accountNumberRequire
     */
    private String accountNumberRequire;
    /**
     * This is variable password
     */
    private String password;
    /**
     * This is variable passwordRequire
     */
    private String passwordRequire;
    /**
     * This is variable captcha
     */
    private String captcha;
    /**
     * This is variable enterCaptcha
     */
    private String enterCaptcha;
    /**
     * This is variable captchaIncorrect
     */
    private String captchaIncorrect;

    /**
     * This is properties getCaptchaIncorrect
     *
     * @return String captchaIncorrect
     */
    public String getCaptchaIncorrect() {
        return captchaIncorrect;
    }

    /**
     * This is properties getAccountNumber
     *
     * @return String accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * This is properties getAccountNumberRequire
     *
     * @return String accountNumberRequire
     */
    public String getAccountNumberRequire() {
        return accountNumberRequire;
    }

    /**
     * This is properties getPassword
     *
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is properties getPasswordRequire
     *
     * @return String passwordRequire
     */
    public String getPasswordRequire() {
        return passwordRequire;
    }

    /**
     * This is properties getCaptcha
     *
     * @return String captcha
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * This is properties getEnterCaptcha
     *
     * @return String enterCaptcha
     */
    public String getEnterCaptcha() {
        return enterCaptcha;
    }

    /**
     * This is variale bundle
     */
    private ResourceBundle bundle;

    /**
     * This is method getContent
     *
     * @param key this is enum LangKey
     * @return String bundle
     */
    public String getContent(LangKey key) {
        return bundle.getString(key.name());
    }

    /**
     * This is method setLocate
     *
     * @param locate This is enum Locate
     */
    public void setLocate(Locate locate) {
        bundle = ResourceBundle.getBundle(locate.name());
        accountNumber = getContent(LangKey.ACCOUNT_NUMBER);
        accountNumberRequire = getContent(LangKey.ACCOUNT_NUMBER_REQUIRE);
        password = getContent(LangKey.PASSWORD);
        passwordRequire = getContent(LangKey.PASSWORD_REQIRE);
        captcha = getContent(LangKey.CAPTCHA);
        enterCaptcha = getContent(LangKey.ENTER_CAPTCHA);
        captchaIncorrect = getContent(LangKey.CAPTCHA_INCORRECT);
    }

    /**
     * This is constructor
     */
    public Language() {
    }
}
