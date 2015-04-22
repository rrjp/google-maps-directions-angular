package org.reyes.googlemapsdirections.util.manifest;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Manifest;

/**
 * Quick and dirty class for reading manifest files.
 */
public class About
{
    /**
     * Relative path to the manifest file.
     */
    public final static String explodedWarManifestPath = "META-INF/MANIFEST.MF";

    /**
     * Get the manifest.
     *
     * @param servletContext Servlet context.
     *
     * @return The manifest.
     *
     * @throws IOException
     */
    public static Manifest explodedWarManifest(ServletContext servletContext) throws IOException
    {
        return fileManifest(servletContext.getRealPath(explodedWarManifestPath));
    }

    /**
     * Get the manifest.
     *
     * @param warFile Path to a WAR file.
     *
     * @return Not implemented.
     *
     * @throws IOException
     */
    public static Manifest warManifest(String warFile) throws IOException
    {
        return null;  // todo
    }

    /**
     * Get the manifest.
     *
     * @param jarFile Path to a JAR file.
     *
     * @return Not implemented.
     *
     * @throws IOException
     */
    public static Manifest jarManifest(String jarFile) throws IOException
    {
        return null;  // todo
    }

    /**
     * Read manifest file.
     *
     * @param manifestFile Path to the manifest file.
     *
     * @return The manifest.
     *
     * @throws IOException
     */
    public static Manifest fileManifest(String manifestFile) throws IOException
    {
        InputStream is = new FileInputStream(manifestFile);
        return new Manifest(is);
    }
}
