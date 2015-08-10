/**
 * Copyright © 2015 Ruben Piatnitsky
 * This program is released under the "GNU license".
 * Please see the file LICENSE in this distribution for
 * license terms.
 *
 * Created by Ruben Piatnitsky on 7/14/15.
 */

package com.bulletingroupblast.bulletingroupblast;

import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

public class SecurityUtil {

    /*TODO: Add Salt function here*/
    protected String salt(String MD5Password, Date dateCreated) {
        String Salt = dateCreated.toString() + generateRandomString(16);
        return (MD5Password + Salt) + Salt;
    }

    /** Create an MD5 hash of a string
     * @param input is the password or string you want encrypted
     * @return MD5 hash string
     */
    public static String MD5Hash(String input) {
        String MD5Result = null;

        if(null != input) {
            try {
                //Create MessageDigest object for MD5
                MessageDigest digest = MessageDigest.getInstance("MD5");

                //Update input string in message digest
                digest.update(input.getBytes(), 0, input.length());

                //Converts message digest value in base 32 (hex)
                MD5Result = new BigInteger(1, digest.digest()).toString(32);

            } catch (NoSuchAlgorithmException e) {
                Log.e(e.getCause().toString(), e.getMessage()); // Output to log file
            }
        }
        return MD5Result;
    }

    /** Create a random string of a specified size
     * @param size
     * @return Random String of specified size
     */
    public static String generateRandomString(int size) {
        char[] randString = new char[size];
        int aMin = 33;              // The smallest ascii value
        int aMax = 126;             // The largest ascii value
        Random r = new Random();    // Random generator
        char charVal = 0;

        for (int i = 0; i < size; i++) {
            //randString[i] = Character.toChars(r.nextInt(aMax - aMin) + aMin); // generate a random number
        }

        return randString.toString();
    }

    /** Sanitize the HTML string from malicious scripts
     * @param html code for sanitization
     * @return Sanitized string
     */
    public static String SanitizeHTML(String html) {
        return null;
    }

    /** Sanitize the SQL to prevent injections
     * @param strSQL the SQL string to be sanitized
     * @return sanitized string
     */
    public static String SanitizeSQL(String strSQL) {
        return null;
    }

}
