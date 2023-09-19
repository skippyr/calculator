const fileSystemModule   = require("fs");
const pathModule         = require("path");
const childProcessModule = require("child_process");

function parseOption(option, optionAction)
{
    if (process.argv.includes(`--${option}`))
    {
        optionAction();
    }
}

function logInfo(message)
{
    console.log(`INFO: ${message}`);
}

function createDirectory(directoryPath)
{
    const creationProperties = {recursive : true, force : true};
    fileSystemModule.mkdirSync(directoryPath, creationProperties);
}

function removeDirectory(directoryPath)
{
    const removalProperties = {recursive : true, force : true};
    fileSystemModule.rmSync(directoryPath, removalProperties);
}

function compileJavaClasses(sourcesDirectoryPath, buildDirectoryPath, mainClassFilePath)
{
    childProcessModule.execSync(`javac -cp ${sourcesDirectoryPath} -d ${buildDirectoryPath} ${mainClassFilePath}`);
}

function compressJarFile(jarFilePath, mainClass, buildDirectoryPath)
{
    childProcessModule.execSync(`jar -cfe ${jarFilePath} ${mainClass} -C ${buildDirectoryPath} .`);
}

function runJarFile(jarFilePath)
{
    const executionProperties = {stdio : "inherit"};
    childProcessModule.execSync(`java -jar ${jarFilePath}`, executionProperties);
}

function main()
{
    const projectDirectoryPath  = __dirname;
    const sourcesDirectoryPath  = pathModule.join(projectDirectoryPath, "sources");
    const outDirectoryPath      = pathModule.join(projectDirectoryPath, "out");
    const buildDirectoryPath    = pathModule.join(outDirectoryPath, "build");
    const releasesDirectoryPath = pathModule.join(outDirectoryPath, "releases");
    const packageName           = pathModule.join("com", "github", "skippyr", "calculator");
    const mainClassName         = "Calculator";
    const mainClass             = pathModule.join(packageName, mainClassName);
    const mainClassFilePath     = pathModule.join(sourcesDirectoryPath, packageName, `${mainClassName}.java`);
    const jarFilePath           = pathModule.join(releasesDirectoryPath, `${mainClassName}.jar`);
    console.log("--- Building ---");
    logInfo("Creating directory structure.");
    console.log(`    - Out Directory      : ${outDirectoryPath}.`);
    console.log(`    - Build Directory    : ${buildDirectoryPath}.`);
    console.log(`    - Releases Directory : ${releasesDirectoryPath}.`);
    removeDirectory(outDirectoryPath);
    createDirectory(buildDirectoryPath);
    createDirectory(releasesDirectoryPath);
    logInfo("Compiling Java classes.");
    compileJavaClasses(sourcesDirectoryPath, buildDirectoryPath, mainClassFilePath);
    logInfo("Compressing Jar file.");
    compressJarFile(jarFilePath, mainClass, buildDirectoryPath);
    logInfo("Build done successfully.");
    parseOption("run", () => {
        logInfo("Running jar File.");
        console.log();
        runJarFile(jarFilePath);
    });
}

main();