# Set JAVA_HOME and Import Certificates (macOS)

This guide shows how to set `JAVA_HOME` for Zsh and Bash on macOS and how to import certificates into the Java truststore (`cacerts`). Use the certificate files you have in your current working directory (for example: `prx-qa.manager.crt`, `backbone.crt`, `srmn.crt`, `prx-qa.config-server.crt`).

---

## Checklist

- [ ] Add `export JAVA_HOME=$(/usr/libexec/java_home)` to your shell profile (`~/.zshrc` or `~/.bash_profile`).
- [ ] Source the profile to apply changes immediately.
- [ ] Create a backup of the JVM `cacerts` file before modifying it.
- [ ] Import certificates into the JVM truststore (use `sudo` if required).
- [ ] Verify the imports and restart any Java-based applications/services.

---

## Notes and prerequisites

- These steps target macOS and assume `java` (JDK) is installed. To list installed JDKs run:

```bash
/usr/libexec/java_home -V
```

- Editing `cacerts` requires administrative privileges. If you get permission errors, re-run the `keytool` commands with `sudo`.

- The default `cacerts` password is `changeit`. If your JDK uses a different password, replace `-storepass changeit` accordingly.

- Run commands from the directory where the `.crt` files are located, or use absolute paths to the `.crt` files.

---

## Zsh (recommended on modern macOS)

1. Open your Zsh profile in a text editor:

```bash
nano ~/.zshrc
```

2. Add the following line at the end of the file:

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
```

3. Save and exit:

- Press `Ctrl+O` (write out), press `Enter` to confirm the filename.
- Press `Ctrl+X` to exit `nano`.

4. Apply the changes immediately:

```bash
source ~/.zshrc
```

5. Verify `JAVA_HOME`:

```bash
echo "$JAVA_HOME"
```

---

## Bash

1. Open your Bash profile:

```bash
nano ~/.bash_profile
```

2. Add the following line:

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
```

3. Save and exit (`Ctrl+O`, `Enter`, `Ctrl+X`).

4. Apply the changes:

```bash
source ~/.bash_profile
```

5. Verify `JAVA_HOME`:

```bash
echo "$JAVA_HOME"
```

---

## Backup `cacerts` (recommended)

Before importing certificates, back up the existing `cacerts` file:

```bash
sudo cp "$JAVA_HOME/lib/security/cacerts" "$JAVA_HOME/lib/security/cacerts.bak.$(date +%s)"
```

This creates a timestamped backup you can restore if needed.

---

## Import the certificates into the JVM truststore

Run these commands from the directory containing the `.crt` files (or update the file paths to point to them). Use `sudo` if you need elevated permissions.

```bash
# Import prx-qa.manager.crt
sudo keytool -import -alias prx-qa.manager.tst \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -file prx-qa.manager.crt \
  -storepass changeit -noprompt

# Import backbone.crt
sudo keytool -import -alias backbone.tst \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -file backbone.crt \
  -storepass changeit -noprompt

# Import srmn.crt
sudo keytool -import -alias srmn \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -file srmn.crt \
  -storepass changeit -noprompt

# Import prx-qa.config-server.crt
sudo keytool -import -alias prx-qa.config-server \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -file prx-qa.config-server.crt \
  -storepass changeit -noprompt
```

If you prefer not to prefix each command with `sudo`, open a root shell temporarily:

```bash
sudo -s
# run the keytool commands (without sudo), then exit when finished
exit
```

---

## Verify the imports

List the imported aliases to confirm they were added:

```bash
sudo keytool -list \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -storepass changeit | grep -E "prx-qa.manager.tst|backbone.tst|srmn|prx-qa.config-server"
```

Or show details for a specific alias:

```bash
sudo keytool -list -v \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -alias prx-qa.manager.tst \
  -storepass changeit
```

---

## Restore backup (if needed)

If something goes wrong, restore the backup created earlier:

```bash
sudo cp "$JAVA_HOME/lib/security/cacerts.bak.<TIMESTAMP>" "$JAVA_HOME/lib/security/cacerts"
```

Replace `<TIMESTAMP>` with the timestamp from your backup filename.

---

## Restart Java apps/services

After changing `cacerts`, restart any Java-based services, applications, or your IDE so they pick up the updated truststore.

Examples:

- Restart a Spring Boot app you run locally (stop and start the process).
- Restart your IDE if it relies on the system JDK.

---

## Troubleshooting

- Permission denied when writing to `cacerts`: re-run with `sudo`.

- Alias already exists: delete and re-import:

```bash
sudo keytool -delete -alias backbone.tst \
  -keystore "$JAVA_HOME/lib/security/cacerts" -storepass changeit

sudo keytool -import -alias backbone.tst \
  -keystore "$JAVA_HOME/lib/security/cacerts" \
  -file backbone.crt -storepass changeit -noprompt
```

- `JAVA_HOME` empty or incorrect: run `/usr/libexec/java_home` to see available JDK installations and set a specific version, for example:

```bash
# Set JAVA_HOME to a specific JDK
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
```

- If `keytool` is not found, ensure JDK bin directory is on your `PATH` or run it from the JDK bin path, e.g.:

```bash
"$JAVA_HOME/bin/keytool" -help
```

---

If you want, I can also provide:

- A small interactive script to apply the `~/.zshrc`/`~/.bash_profile` changes and import the certs (with prompts and backups).
- Commands to list JDKs or pin `JAVA_HOME` to a specific installation.

